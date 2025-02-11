$(document).ready(function () {
  let isEditing = false;
  const baseUrl = 'http://localhost:8081/10_Back_End_Web_exploded/api/v1/customer';

  loadCustomers();

  $('#customerForm').submit(function (e) {
    e.preventDefault();

    const customerData = {
      id: $('#id').val(),
      name: $('#name').val(),
      address: $('#address').val(),
      age: parseInt($('#age').val())
    };

    const url = isEditing ? `${baseUrl}/update` : `${baseUrl}/save`;
    const method = isEditing ? 'PUT' : 'POST';

    $.ajax({
      url: url,
      type: method,
      contentType: 'application/json',
      data: JSON.stringify(customerData),
      success: function (response) {
        loadCustomers();
        clearForm();
        Swal.fire({
          icon: 'success',
          title: 'Success!',
          text: `Customer ${isEditing ? 'updated' : 'saved'} successfully!`,
          timer: 2000,
          showConfirmButton: false
        });
      },
      error: function (xhr, status, error) {
        Swal.fire({
          icon: 'error',
          title: 'Error!',
          text: 'Error: ' + error,
          confirmButtonText: 'OK'
        });
      }
    });
  });

  function loadCustomers() {
    $.ajax({
      url: `${baseUrl}/getAll`,
      type: 'GET',
      success: function (customers) {
        $('#customerTableBody').empty();
        customers.forEach(function (customer) {
          $('#customerTableBody').append(`
              <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.age}</td>
                <td>
                  <button class="btn btn-sm btn-warning btn-action" onclick="editCustomer('${customer.id}', '${customer.name}', '${customer.address}', ${customer.age})">Edit</button>
                  <button class="btn btn-sm btn-danger btn-action" onclick="deleteCustomer('${customer.id}')">Delete</button>
                </td>
              </tr>
            `);
        });
      },
      error: function (xhr, status, error) {
        Swal.fire({
          icon: 'error',
          title: 'Error!',
          text: 'Error loading customers: ' + error,
          confirmButtonText: 'OK'
        });
      }
    });
  }

  $('#clearBtn').click(clearForm);

  function clearForm() {
    $('#customerForm')[0].reset();
    isEditing = false;
    $('#formTitle').text('Add New Customer');
    $('#submitBtn').text('Save Customer');
    $('#id').prop('readonly', false);
  }

  window.editCustomer = function (id, name, address, age) {
    $('#id').val(id);
    $('#name').val(name);
    $('#address').val(address);
    $('#age').val(age);
    $('#id').prop('readonly', true);

    isEditing = true;
    $('#formTitle').text('Edit Customer');
    $('#submitBtn').text('Update Customer');
  };

  window.deleteCustomer = function (id) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        $.ajax({
          url: `${baseUrl}/delete/${id}`,
          type: 'DELETE',
          success: function (response) {
            if (response) {
              loadCustomers();
              Swal.fire({
                icon: 'success',
                title: 'Deleted!',
                text: 'Customer has been deleted.',
                timer: 2000,
                showConfirmButton: false
              });
            } else {
              Swal.fire({
                icon: 'error',
                title: 'Error!',
                text: 'Customer not found!',
                confirmButtonText: 'OK'
              });
            }
          },
          error: function (xhr, status, error) {
            Swal.fire({
              icon: 'error',
              title: 'Error!',
              text: 'Error deleting customer: ' + error,
              confirmButtonText: 'OK'
            });
          }
        });
      }
    });
  };
});
