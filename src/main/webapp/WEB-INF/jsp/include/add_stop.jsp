<!-- SIGN UP FORM -->
<div class="modal fade text-start" id="addStopModal" tabindex="-1" aria-labelledby="addStopModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="addStopModalLabel">Add New Stop</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="needs-validation" style="width: 500px;" action="/admin/addstop" method="POST">
                    <div class="container">
                        <div class="row mt-3">
                            <div class="col">
                                <label for="stopName" class="form-label">Stop Name<span
                                        class="text-danger">*</span></label>
                                <div class="has-validation">
                                    <input type="text" name="stopName" class="form-control" id="stopName"
                                        value="${form.stopName}" required />
                                    <div class="text-danger">
                                        ${stopNameMessage}
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
                                <jsp:include page="state_dropdown.jsp"></jsp:include>
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
                            <div class="col-12 my-4 text-center">
                                <button type="submit" class="btn btn-warning px-4">Add</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

