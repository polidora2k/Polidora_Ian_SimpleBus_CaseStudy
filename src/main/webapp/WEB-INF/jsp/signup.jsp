<jsp:include page="include/header.jsp" />

<title>Sign Up</title>

<body style="font-family: FredokaOne; background-color: #EFF3F3;">
    <div class="d-flex vh-100 flex-column">
        <!-- NAVIGATION BAR -->
        <jsp:include page="include/navbar.jsp" />

        <!-- SIGN UP FORM -->
        <div class="border align-self-center shadow rounded p-3 my-auto bg-light ">
            <form class="needs-validation" style="width: 500px;" action="/user/signup" method="POST" novalidate>
                <h1 class="text-center mb-4 mt-3">Sign Up</h1>
                <div class="container">
                    <div class="row mb-4">
                        <div class="btn-group" name="user-type" role="group" aria-label="User Type Select">
                            <input type="radio" class="btn-check" name="role" id="parent" autocomplete="off" checked
                                value="Parent" required />
                            <label class="btn btn-outline-warning" for="parent">Parent</label>

                            <input type="radio" class="btn-check" name="role" id="driver" autocomplete="off"
                                value="Driver" required />
                            <label class="btn btn-outline-warning" for="driver">Driver</label>
                        </div>
                    </div>
                    <div class="row mb-4 mt-5">
                        <div class="col-md-6 mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <div class="has-validation">
                                <input type="text" name="firstName" class="form-control" id="firstName" required />
                                <div class="invalid-feedback">
                                    Please provide your first name.
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input type="text" name="lastName" class="form-control" id="lastName" required />
                            <div class="invalid-feedback">
                                Please provide your last name.
                            </div>
                        </div>
                        <div class="col-12 mb-3 has-validation">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" name="email" class="form-control" id="email" required />
                            <div style="color: red;">
                                ${emailMessage}
                            </div>
                        </div>
                        <div class="col-12 mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" name="password" class="form-control" id="password" required />
                            <div id="passwordHelp" class="form-text">Password must be atleast 8 characters with one
                                uppercase letter, one lowercase letter, a number, and one of the following special
                                characters: @, #, $, &, %, !.</div>
                            <div style="color: red;">
                                ${passwordMessage}
                            </div>
                        </div>
                        <div class="col-12">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" name="confirmPassword" class="form-control" id="confirmPassword"
                                required />
                            <div style="color: red;">
                                ${confirmPasswordMessage}
                            </div>
                        </div>
                        <div class="col-12 my-4 text-center">
                            <button type="submit" class="btn btn-warning px-4">Sign Up</button>
                        </div>
                        <div class="row mt-4 p-4 border-top">
                            <div class="col text-end align-self-center">
                                Have an account?
                            </div>
                            <div class="col">
                                <a href="/user/login" class="btn btn-warning px-5">Login</a>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>

</html>