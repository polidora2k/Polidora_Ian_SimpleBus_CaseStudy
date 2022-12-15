<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <title>Add Stop</title>

    <jsp:include page="include/header.jsp" />

    <body style="font-family: FredokaOne; background-color: #EFF3F3;">
        <div class="d-flex vh-100 flex-column">
            <!-- NAVIGATION BAR -->
            <jsp:include page="include/navbar.jsp" />

            <!-- SIGN UP FORM -->
            <div class="border align-self-center shadow rounded p-3 my-auto bg-light ">
                <form class="needs-validation" style="width: 500px;" action="/admin/addroute/${routeId}/addstops" method="POST">
                    <h1 class="modal-title fs-5" id="addStopModalLabel">Add New Stop</h1>
                    <div class="container">
                        <div class="row mt-3">
                            <div class="col">
                                <label for="stopName" class="form-label">Stop Name<span
                                        class="text-danger">*</span></label>
                                <div class="has-validation">
                                    <input type="text" name="name" class="form-control" id="name"
                                        value="${form.name}" required />
                                    <div class="text-danger">
                                        ${nameMessage}
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col">
                                <label for="streetAddress" class="form-label">Street Address<span
                                        class="text-danger">*</span></label>
                                <input type="text" name="streetAddress" class="form-control" id="streetAddress"
                                    value="${form.streetAddress}" required />
                                <div class="text-danger">
                                    ${streetAddressMessage}
                                </div>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col">
                                <label for="city" class="form-label">City<span class="text-danger">*</span></label>
                                <input type="text" name="city" class="form-control" id="city" value="${form.city}"
                                    required />
                                <div class="text-danger">
                                    ${cityMessage}
                                </div>
                            </div>
                            <div class="col">
                                <label for="state" class="form-label">State<span class="text-danger">*</span></label>
                                <jsp:include page="include/state_dropdown.jsp"></jsp:include>
                                <div class="text-danger">
                                    ${stateMessage}
                                </div>
                            </div>
                            <div class="col">
                                <label for="zipcode" class="form-label">Zipcode<span
                                        class="text-danger">*</span></label>
                                <input type="text" name="zipcode" pattern="[\d]*" class="form-control" id="zipcode"
                                    value="${form.zipcode}" maxlength="5" required />
                                <div class="text-danger">
                                    ${zipcodeMessage}
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6 my-4 text-center">
                                <button type="submit" class="btn btn-warning px-4">Add</button>
                            </div>
                            <div class="col-6 my-4 text-center">
                                <a href="/admin" class="btn btn-warning px-4">Done</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>

    <jsp:include page="include/footer.jsp" />

