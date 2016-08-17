<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<script>
    $.getJSON('/api/person/list', {
        ajax: 'true'
    }, function (data) {
        console.log(data)
        $.each(data, function (index, single) {
            $('#test').append(single.firstName);
        })
    })
</script>

<div class="container spacer-100">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">

                ${firstName}

                <hr>

                    <span id="test"></span>
                ${personList}

            </div>
        </div>
    </div>
</div>
