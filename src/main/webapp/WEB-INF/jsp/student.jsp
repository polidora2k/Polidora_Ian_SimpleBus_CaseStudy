<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Add Student</title>

        <jsp:include page="include/header.jsp" />
        <link rel="stylesheet" href="/styles/student.css" type="text/css" />
        <script src="/scripts/student.js"></script>

        <body style="font-family: FredokaOne; background-color: #EFF3F3;" onload="setRidingCheckbox(${student.riding})">
            <div class="d-flex vh-100 flex-column">
                <!-- NAVIGATION BAR -->
                <jsp:include page="include/navbar.jsp" />

                <div class="border align-self-center shadow rounded p-3 my-auto bg-light w-50 container">
                    <div class="row border-bottom border-4 pb-3">
                        <div class="col-3">
                            <img class="rounded-circle width" style="width:150px;" src="/images/blank_pfp.jpg"
                                alt="Profile Picture">
                        </div>
                        <div class="col-9">
                            <input type="hidden" value="${student.id}" id="studentId" name="studentId">
                            <div class="row">
                                <h2>${student.firstName} ${student.lastName}</h2>
                            </div>
                            <div class="row">
                                <p class="mb-0">${student.streetAddress}</p>
                            </div>
                            <div class="row">
                                <p class="mt-0">${student.city}, ${student.state} ${student.zipcode}</p>
                            </div>
                            <div class="row d-flex">
                                <div class="form-check-reverse form-switch align-self-start d-flex ms-2">
                                    <label class="form-check-label ps-1" for="ridingCheckBox">Riding Today:</label>
                                    <input class="form-check-input ms-2" type="checkbox" role="switch"
                                        id="ridingCheckBox" >
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-3 ms-4">
                        <div class="col">
                            <h5>Status:</h5>
                        </div>
                    </div>
                    <c:if test="${student.riding}">
                        <div class="row mt-2">
                            <div class="col text-center">
                              <c:if test="${status.arrived}">
                                <h2 class="text-success">
                                  ${student.firstName} is Home!</h2>
                              </c:if>
                              <c:if test="${not status.arrived}">
                                <c:if test="${not status.routeInProgress}">
                                  <div class="row">
                                    <div class="col">
                                      <h2 class="text-secondary">Bus has not departed</h2>
                                    </div>
                                  </div>
                                </c:if>
                                <c:if test="${status.routeInProgress and status.previousStop == null}">
                                  <div class="row">
                                    <div class="col">
                                      <h2 class="text-secondary">Bus has departed...</h2>
                                    </div>
                                  </div>
                                </c:if>
                                <c:if test="${status.routeInProgress and status.previousStop != null}">
                                  <div class="row">
                                    <div class="col">
                                      <h2 class="text-warning">Last Stop Passed:</h2>
                                    </div>
                                  </div>
                                  <div class="row">
                                    <div class="col stop-info">
                                      ${status.previousStop.name}
                                    </div>
                                  </div>
                                  <div class="row">
                                    <div class="col stop-info">
                                      ${status.previousStop.streetAddress}
                                    </div>
                                  </div>
                                  <div class="row">
                                    <div class="col stop-info">
                                      ${status.previousStop.city},
                                      ${status.previousStop.state}
                                      ${status.previousStop.zipcode}
                                    </div>
                                  </div>
                                </c:if>
                              </c:if>
                            </div>
                          </div>

                          <div class="progress w-100 my-4">
                            <c:if test="${status.arrived}">
                              <div class="progress-bar bg-success progress-bar-striped" role="progressbar"
                                aria-label="routeStatus" style="width: 100%" aria-valuenow="100" aria-valuemin="0"
                                aria-valuemax="100"></div>
                            </c:if>
                            <c:if test="${not status.arrived}">
                              <div class="progress-bar bg-warning progress-bar-striped progress-bar-animated"
                                role="progressbar" aria-label="routeStatus"
                                style="width: ${status.percent}%;"
                                aria-valuenow="status.percent" aria-valuemin="0"
                                aria-valuemax="100"></div>
                            </c:if>
                          </div>
                    </c:if>
                    <c:if test="${not student.riding}">
                        <div class="row mt-2">
                            <div class="col text-center">
                                <h2 class="text-secondary">
                                    ${student.firstName} is not riding today!</h2>
                            </div>
                        </div>
                    </c:if>
                    <div class="row">
                        <div class="col p-4 ps-5">
                            <div class="row">
                                <div class="col">
                                    <h5>Home Stop Information:</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col stop-info">
                                    ${stop.name}
                                </div>
                            </div>
                            <div class="row">
                                <div class="col stop-info">
                                    ${stop.streetAddress}
                                </div>
                            </div>
                            <div class="row">
                                <div class="col stop-info">
                                    ${stop.city}, ${stop.state} ${stop.zipcode}
                                </div>
                            </div>
                        </div>
                        <div class="col p-4 ps-5">
                            <div class="row">
                                <div class="col">
                                    <h5>Driver:</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-3">
                                    <img class="rounded-circle width" style="width: 75px;" src="/images/blank_pfp.jpg"
                                        alt="Profile Picture">
                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col">
                                            ${driver.firstName} ${driver.lastName}
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </body>


        <jsp:include page="include/footer.jsp" />