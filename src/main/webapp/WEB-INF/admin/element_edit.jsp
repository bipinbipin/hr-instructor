<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<%@include file="../includes/subnavbar_admin.jsp" %>

<script>
    $(document).ready(function() {

//        $('.clear').each(function() {
            $('.clear').click(function() {
                console.log(this.name);
                console.log($('#'+this.name).val());
                $('#'+this.name).val('');
                $('#elementType').submit();
            });
//        });

    });

</script>

<div class="wrapper">

    <%@include file="sidemenu.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <c:set var="idx" value="0" scope="page" />
            <form:form cssClass="form-horizontal" modelAttribute="elementType" action="/admin/element/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />

                <div class="row">
                    <div class="form-group">
                        <label for="inputElementTypeName" class="col-sm-2 control-label">Element Type</label>
                        <div class="col-sm-10">
                            <form:input type="text" cssClass="form-control" id="inputElementTypeName" path="elementTypeName"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>

                <c:forEach items="${elementType.elementList}" var="element">
                    <form:hidden path="elementList[${idx}].id" />
                    <form:hidden path="elementList[${idx}].version" />
                    <div class="row">
                        <div class="form-group">
                            <label for="${idx}" class="col-sm-3 control-label">Element</label>
                            <div class="col-sm-7">
                                <div class="input-group">
                                <form:input type="text" class="form-control" path="elementList[${idx}].elementName" id="${idx}"/>
                                    <span class="input-group-btn">
                                        <button name="${idx}" class="btn btn-default clear" type="button">Remove</button>
                                    </span>
                            </div>
                            </div>
                        </div>
                    </div>
                    <c:set var="idx" value="${idx + 1}" scope="page" />
                </c:forEach>

                <div class="row">
                    <div class="form-group">
                        <label for="inputNewElement" class="col-sm-3 control-label">Element</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="inputNewElement"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <button class="btn btn-primary">UPDATE</button>
                </div>

            </form:form>


        </div>
    </div>

</div>





<%@include file="../includes/footer.jsp" %>