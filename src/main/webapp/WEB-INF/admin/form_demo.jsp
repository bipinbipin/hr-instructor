<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<%@include file="../includes/subnavbar_admin.jsp" %>

<div class="container">
    <div class="col-lg-8 col-md-7 col-sm-6">

        <c:set var="idx" value="0" scope="page" />
        <form:form class="form-horizontal" modelAttribute="formDemoVO" action="/admin/form_demo" method="post">
            <fieldset>
                <legend>Form Input Demo</legend>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                    <div class="col-lg-10">
                        <form:input path="email" type="text" class="form-control" id="inputEmail" placeholder="Email"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                        <form:input path="password" type="password" class="form-control" id="inputPassword" placeholder="Password"></form:input>
                        <div class="checkbox">
                            <label>
                                <form:checkbox path="checkboxes" value="CheckBox1"></form:checkbox>Checkbox 1
                            </label>
                            <label>
                                <form:checkbox path="checkboxes" value="CheckBox2"></form:checkbox>Checkbox 2
                            </label>
                            <label>
                                <form:checkbox path="checkboxes" value="CheckBox3"></form:checkbox>Checkbox 3
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-2 control-label">Nested CheckBox</label>
                    <div class="col-lg-10">

                        <c:forEach items="${formDemoVO.checkBoxList}"  var="chkbox">

                            <label>
                                <form:checkbox path="checkBoxList[${idx}].checkBox" value="${chkbox.checkBox}"></form:checkbox>${chkbox.checkBox}
                            </label>

                            <c:set var="idx" value="${idx + 1}" scope="page" />
                        </c:forEach>
                    </div>
                </div>

                <div class="form-group">
                    <label for="textArea" class="col-lg-2 control-label">Textarea</label>
                    <div class="col-lg-10">
                        <form:textarea path="textarea" class="form-control" rows="3" id="textArea"></form:textarea>
                        <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Radios</label>
                    <div class="col-lg-10">
                        <div class="radio">
                            <label>
                                <form:radiobutton path="radios" name="optionsRadios" id="optionsRadios1" value="option1" checked=""></form:radiobutton>
                                Option one is this
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <from:radiobutton path="radios" name="optionsRadios" id="optionsRadios2" value="option2"></from:radiobutton>
                                Option two can be something else
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="select" class="col-lg-2 control-label">Selects</label>
                    <div class="col-lg-10">
                        <form:select path="selectSingle" class="form-control" id="select">
                            <form:options items="${singleList}" />
                        </form:select>
                        <br>
                        <form:select path="selectMultiple" multiple="true" class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                        <form:button type="submit" value="submit" class="btn btn-primary">Submit</form:button>
                    </div>
                </div>
            </fieldset>
        </form:form>


    </div>
</div>






<%@include file="../includes/footer.jsp" %>