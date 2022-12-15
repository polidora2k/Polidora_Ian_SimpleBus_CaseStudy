<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Add Route</title>

        <jsp:include page="include/header.jsp" />

        <body style="font-family: FredokaOne; background-color: #EFF3F3;">
            <div class="d-flex vh-100 flex-column">
                <!-- NAVIGATION BAR -->
                <jsp:include page="include/navbar.jsp" />

                <!-- SIGN UP FORM -->
                <div class="border align-self-center shadow rounded p-3 my-auto bg-light ">
                    <form class="needs-validation" style="width: 500px;" action="/admin/addroute" method="POST"
                        novalidate>
                        <h1 class="text-left mb-4 mt-3 ms-3">Edit Routes</h1>
                        <div class="container">
                            <div class="row mt-3">
                                <div class="col">
                                    <ul class="list-group">
                                        <c:forEach items="${routes}" var="route">
                                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                                ${route.name}
                                                <a href="/admin/addroute/${route.id}/addstops" class="btn btn-warning">Add Stops</a>
                                        </c:forEach>
                                      </ul>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 my-4 text-center">
                                    <button type="submit" class="btn btn-warning px-4">Add</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </body>

        <jsp:include page="include/footer.jsp" />