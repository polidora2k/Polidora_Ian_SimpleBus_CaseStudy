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
                        <h1 class="text-left mb-4 mt-3 ms-3">Add New Route</h1>
                        <div class="container">
                            <div class="row mt-3">
                                <div class="col">
                                    <label for="routeName" class="form-label">Route Name<span
                                            class="text-danger">*</span></label>
                                    <div class="has-validation">
                                        <input type="text" name="routeName" class="form-control" id="routeName"
                                            value="${form.routeName}" required />
                                        <div class="text-danger">
                                            ${firstNameMessage}
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col ">
                                    <div class="row">
                                        <div class="col">
                                            <label for="stops" class="form-label">Included Stops</label>
                                        </div>
                                        <div class="col text-end">
                                            <button type="button" class="btn btn-warning mb-2" data-bs-toggle="modal" data-bs-target="#addStopModal" style="font-size: 10pt;">
                                                + Add Stop
                                              </button>
                                              <jsp:include page="include/add_stop.jsp"/>
                                        </div>
                                    </div>
                                    <div class="overflow-auto border bg-white rounded" style="height: 200px;">
                                        <c:if test="${empty unassignedStops}">
                                            <div class="text-center w-100 h-100">
                                                <span class=" align-middle text-muted">No unassigned stops</span>
                                            </div>
                                        </c:if>
                                        <c:if test="${not empty unassignedStops}">
                                            <ul class="list-group">
                                                <c:forEach items="${unassignedStops}" var="stop">
                                                    <li class="list-group-item bg-light">
                                                        <input class="form-check-input me-1" type="checkbox"
                                                            value="${stop.id}" id="stop${stop.id}">
                                                        <label class="form-check-label stretched-link"
                                                            for="stop${stop.id}">${stop.name}</label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </c:if>
                                    </div>
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

        </html>