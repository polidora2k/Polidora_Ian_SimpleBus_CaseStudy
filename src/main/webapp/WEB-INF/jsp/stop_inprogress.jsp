<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Route</title>

        <jsp:include page="include/header.jsp" />
        <link rel="stylesheet" href="/styles/student.css" type="text/css" />

        <script>
            $(document).ready(function() {
                $("#finish").click(function() {
                    $.ajax({
                        url: "/completeroute",
                        data: {
                            routeId: "${route.id}"
                        },
                        success: function(result) {
                            console.log(result);
                            window.location = $("#finish").val();
                        },
                        error: function(result) {
                            console.log(result.status);
                        }
                    });
                });
            });
            $(document).ready(function() {
                $("#nextStop").click(function() {
                    $.ajax({
                        url: "/completestop",
                        data: {
                            stopId: "${currentStop.id}",
                            routeId: "${route.id}"
                        },
                        success: function(result) {
                            console.log(result);
                            window.location = $("#nextStop").val();
                        },
                        error: function(result) {
                            console.log(result.status);
                        }
                    });
                });
            });
        </script>

        <body style="font-family: FredokaOne; background-color: #EFF3F3;">
            <div class="d-flex vh-100 flex-column">
                <!-- NAVIGATION BAR -->
                <jsp:include page="include/navbar.jsp" />

                <div class="border align-self-center shadow rounded p-3 my-auto bg-light container">
                    <div class="row border-bottom border-4 pb-3">
                        <div class="col">
                            <input type="hidden" value="${route.id}" id="routeId" name="routeId">
                            <div class="row">
                                <h2>Next Stop: ${currentStop.name}</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-4 p-4 ps-5">
                            <h5>Students Departing:</h5>
                            <p class="text-danger"
                                style="font-size: 9pt; font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                                Ensure that all students departing at this stop have exited the bus</p>
                            <div class="overflow-auto border rounded" style="height: 400px; background-color: #EFF3F3;">
                                <c:if test="${empty students}">
                                    <div class="text-center w-100 h-100">
                                        <span class=" align-middle text-muted">No Students Departing</span>
                                    </div>
                                </c:if>
                                <c:if test="${not empty students}">
                                    <ul class="list-group">
                                        <c:forEach items="${students}" var="student">
                                            <li class="list-group-item bg-light">
                                                <input class="form-check-input me-1" type="checkbox"
                                                    value="${student.id}" id="student${student.id}">
                                                <label class="form-check-label stretched-link"
                                                    for="student${student.id}">${student.firstName}
                                                    ${student.lastName}</label>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                            </div>
                            <c:if test="${nextStop == null}">
                                <button id="finish" class="btn btn-warning mt-2 w-100 disabled" value="/driver">Finish Route</button>
                                <a href="/driver" class="btn btn-warning mt-2 w-100 disabled" id="finish1" hidden>Finish
                                    Route</a>
                            </c:if>
                            <c:if test="${nextStop != null}">
                                <button id="nextStop" class="btn btn-warning mt-2 w-100 disabled" value="/driver/route/${route.id}/stop/${nextStop.id}">Next Stop</button>
                                <a href="/driver/route/${route.id}/stop/${nextStop.id}"
                                    class="btn btn-warning mt-2 w-100 disabled" id="nextStop1" hidden>Next Stop</a>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
        </body>

        <script>
            let nextButton = document.getElementById('nextStop');
            let finishButton = document.getElementById('finish');
            let checkboxes = document.querySelectorAll('input[type=checkbox]');

            if (finishButton == null) {
                checkboxes.forEach(function (checkbox) {
                    checkbox.addEventListener('click', function () {
                        var allChecked = true;
                        checkboxes.forEach(function (checkbox) {
                            if (!checkbox.checked) {
                                allChecked = false;
                            }
                        });

                        if (allChecked) {
                            nextButton.classList.remove('disabled');
                        } else {
                            nextButton.classList.add('disabled');
                        }
                    });
                });
            } else if (nextButton == null) {
                checkboxes.forEach(function (checkbox) {
                    checkbox.addEventListener('click', function () {
                        var allChecked = true;
                        checkboxes.forEach(function (checkbox) {
                            if (!checkbox.checked) {
                                allChecked = false;
                            }
                        });

                        if (allChecked) {
                            finishButton.classList.remove('disabled');
                        } else {
                            finishButton.classList.remove('disabled');
                        }
                    });
                });
            }

        </script>

<jsp:include page="include/footer.jsp" />