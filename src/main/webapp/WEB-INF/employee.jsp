<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<c:url value="/static/js/api/employee.js" var="employee" />
<script src="${employee}"></script>

<script>
    $(document).ready(function() {
        buildTable();
    })
</script>

<h2>Employee Page</h2>

<button onclick="buildList()">List People</button>
<p id="employeeList"></p>

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
                            <label for="inputBackground" class="col-lg-2 control-label">Background</label>
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

</script>

<table id="employee-table" class="table table-striped table-hover ">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Background</th>
        <th>Projects</th>
        <th>Edit</th>
        <th>Delete</th>

    </tr>
    </thead>
    <tbody>
        <%--jQuery will append data here--%>
    </tbody>
</table>