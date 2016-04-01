<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<%@include file="../includes/subnavbar_admin.jsp" %>


<div class="wrapper">

    <%@include file="sidemenu.jsp" %>

    <div id="main-wrapper" class="col-md-11 pull-right">
        <div class="col-lg-8 col-md-7 col-sm-6">

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
    </div>

</div>





<%@include file="../includes/footer.jsp" %>