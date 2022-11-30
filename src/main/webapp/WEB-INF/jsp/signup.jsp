<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="include/header.jsp"/>

<body>
    <div class="d-flex vh-100 flex-column">
        <!-- NAVIGATION BAR -->
        <jsp:include page="include/navbar.jsp"/>
        
        <!-- SIGN UP FORM -->
        <form class="border align-self-center shadow rounded p-3 my-auto bg-light needs-validation"
            style="width: 500px;" action="#" method="POST"  modelAttribute="user">
            <h1 class="text-center mb-5 mt-3">Sign Up</h1>
            <div class="container">
                <div class="row mb-4">
                    <div class="btn-group" name="user-type" role="group" aria-label="User Type Select">
                        <input type="radio" class="btn-check" name="role" id="parent" autocomplete="off" path="role" checked/>
                        <label class="btn btn-outline-warning" for="parent" path="role">Parent</label>

                        <input type="radio" class="btn-check" name="role" id="driver" autocomplete="off" path="role"/>
                        <label class="btn btn-outline-warning" for="driver" path="role">Driver</label>
                    </div>
                </div>
                <div class="row mb-4 mt-5">
                    <div class="col-md-6 mb-3">
                        <label for="firstName" class="form-label" path="firstName">First Name</label>
                        <input type="text" name="firstName" class="form-control" id="firstName" path="firstName"/>
                        <div class="invalid-feedback">
                            Please provide your first name.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName" class="form-label" path="lastName">Last Name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName" path="lastName"/>
                        <div class="invalid-feedback">
                            Please provide your last name.
                        </div>
                    </div>
                    <div class="col-12 mb-3 has-validation">
                        <label for="email" class="form-label" path="email">Email</label>
                        <input type="email" name="email" class="form-control" id="email" path="email"/>
                        <div class="invalid-feedback">
                            Please enter a valid email.
                        </div>
                    </div>
                    <div class="col-12 mb-3">
                        <label for="password" class="form-label" path="password">Password</label>
                        <input type="password" name="password" class="form-control" id="password" path="password"/>
                    </div>
                    <div class="col-12">
                        <label for="confirmPassword" class="form-label" path>Confirm Password</label>
                        <input type="password" name="confirmPassword" class="form-control" id="confirmPassword"/>
                    </div>
                    <div class="col-12 my-4 text-center">
                        <button type="submit" class="btn btn-warning px-4">Sign Up</button>
                    </div>
                    <div class="row mt-4 p-4 border-top">
                        <div class="col text-end align-self-center">
                            Have an account?
                        </div>
                        <div class="col">
                            <a href="login.jsp" class="btn btn-warning px-5">Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>

</html>