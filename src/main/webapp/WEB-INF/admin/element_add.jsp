<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<%@include file="../includes/subnavbar_admin.jsp" %>


<div class="wrapper">

    <%@include file="sidemenu.jsp" %>

    <div id="main-wrapper" class="col-xs-10 ">
        <div class="col-xs-8">

        <form:form class="form-horizontal" modelAttribute="elementVO" action="/admin/element" method="post">
            <fieldset>
                <legend>Element Management</legend>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Element Type</label>
                    <div class="col-lg-10">
                        <form:input path="newElementType" type="text" class="form-control" id="inputEmail" placeholder="Element Type"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="textArea" class="col-lg-2 control-label">Elements</label>
                    <div class="col-lg-10">
                        <form:textarea path="newElements" class="form-control" rows="3" id="textArea"></form:textarea>
                        <span class="help-block">Enter each new Element on a new line.</span>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                        <form:button type="submit" value="submit" class="btn btn-primary">Save</form:button>
                    </div>
                </div>
            </fieldset>

        </form:form>

        </div>

        <div class="col-xs-4">
            <div class="${successAlert == null ? 'hidden' : successAlert}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Warning!</h4>
                    <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                </div>
            </div>
            <div class="${errorAlert == null ? 'hidden' : errorAlert}">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
        </div>
    </div>

</div>





<%@include file="../includes/footer.jsp" %>