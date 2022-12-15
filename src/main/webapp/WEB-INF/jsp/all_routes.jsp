<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Routes</title>

        <jsp:include page="include/header.jsp" />

        <body style="font-family: FredokaOne; background-color: #EFF3F3;">
            <div class="d-flex vh-100 flex-column">
                <jsp:include page="include/navbar.jsp" />
                <div class="container w-75 my-3">
                    <div class="row m-1 fs-1">
                        <p> Routes: </p>
                    </div>
                    <div class="row m-2">
                        <div class="col-6">
                            <div class="card text-center">
                                <div class="card-header">
                                    Route Management
                                </div>
                                <div class="card-body">
                                    <p class="card-text">Manage route information and status for your account.</p>
                                    <a href="/admin/addroute" class="btn btn-warning">Add New Route</a>
                                    <a href="/admin/resetroutes" class="btn btn-warning">Reset All Routes</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </body>

        <jsp:include page="include/footer.jsp" />