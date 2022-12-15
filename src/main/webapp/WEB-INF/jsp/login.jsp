<jsp:include page="include/header.jsp"/>

    <title>Login</title>

    <body style="font-family: FredokaOne; background-color: #EFF3F3;">
        <div class="d-flex vh-100 flex-column">
            <!-- NAVIGATION BAR -->
            <jsp:include page="include/navbar.jsp" />

            <div class="border align-self-center shadow rounded p-3 my-auto bg-light" style="width: 500px;">
                <form id="login-form" action="/login/submit" method="POST">
                    <h1 class="text-center mb-4 mt-3">Login</h1>
                    <div class="container">
                        <div class="row">
                            <label for="username" class="col-sm-2 col-form-label me-2">Email</label>
                        </div>
                        <div class="row mb-4">
                            <div>
                                <input type="email" name="username" class="form-control" id="username"
                                    value="${form.email}">
                            </div>
                            <div style="color: red;">
                                ${emailMessage}
                            </div>
                        </div>
                        <div class="row mb-4">
                            <label for="password" class="col-sm-2 col-form-label me-2">Password</label>
                            <div>
                                <input type="password" name="password" class="form-control" id="password">
                            </div>
                            <div style="color: red;">
                                ${passwordMessage}
                            </div>
                        </div>
                        <div class="row justify-content-center mt-5">
                            <div class="col-6 text-center">
                                <button type="submit" id="login-button"
                                    class="btn px-5 btn-warning mx-auto">Login</button>
                            </div>
                        </div>
                        <div class="row mt-4 p-4 border-top">
                            <div class="col text-end align-self-center">
                                Don't have an account?
                            </div>
                            <div class="col">
                                <a href="/user/signup" class="btn btn-warning px-5">Sign Up</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>

    <jsp:include page="include/footer.jsp" />