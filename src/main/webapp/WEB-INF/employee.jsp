<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<h2>Employee Page</h2>

<script>
    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function (data) {
        console.log(data)
        $.each(data, function (index, single) {
            $('#employeeList').append(single.firstName);
            $('#employeeList').append('<br>');
        })
    })
</script>

<p id="employeeList"></p>

<script>
    function saveEmployee() {
        $('#employeeModal').modal('show');
    }
</script>


<button onclick="$('#employeeModal').modal('show')" class="btn">Add New Employee</button>

<div id="employeeModal"class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Add Employee</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <fieldset>

                        <div class="form-group">
                            <label for="inputFirstName" class="col-lg-2 control-label">First Name</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="inputFirstName" placeholder="First Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputLastName" class="col-lg-2 control-label">Last Name</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="inputLastName" placeholder="First Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">Background</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="inputBackground"></textarea>
                            </div>
                        </div>


                    </fieldset>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="saveEmployee()">Save changes</button>
            </div>
        </div>
    </div>
</div>


<script>
    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function (data) {
        console.log(data)
        $.each(data, function (index, single) {

            $("#employee-table").find('tbody')
                    .append($('<tr>'))
                    .append($('<td>').text(single.id))
                    .append($('<td>').text(single.firstName + ' ' + single.lastName))
                    .append($('<td>').text(single.background))
                    .append($('<td>').text(single.projects));

        });
    });
</script>

<table id="employee-table" class="table table-striped table-hover ">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Background</th>
        <th>Projects</th>
    </tr>
    </thead>
    <tbody>
        <%--jQuery will append data here--%>
    </tbody>
</table>