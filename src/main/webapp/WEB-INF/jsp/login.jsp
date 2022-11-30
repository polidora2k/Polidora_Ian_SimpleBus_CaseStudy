<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="shortcut icon" href="../images/favicon.ico">
    <script src="../scripts/login.js"></script>
</head>

<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
    <div class="d-flex vh-100 flex-column">
        <!-- NAVIGATION BAR -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <div class="container-fluid">
                <a href="../index.html" class="navbar-brand">
                    <img src="../images/bus.jpg" alt="logo" width="100">
                    <span>SimpleBus</span>
                </a>
                <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav">
                        <a href="../index.html" class="nav-item nav-link active">Home</a>
                        <a href="#" class="nav-item nav-link">Profile</a>
                        <a href="#" class="nav-item nav-link">Messages</a>
                        <a href="#" class="nav-item nav-link disabled" tabindex="-1">Reports</a>
                    </div>
                    <div class="navbar-nav ms-auto">
                        <a href="#" class="nav-item nav-link">Login/Sign Up</a>
                    </div>
                </div>
            </div>
        </nav>

        <form class="border align-self-center shadow rounded p-3 my-auto bg-light" style="width: 500px;"
            id="login-form">
            <h1 class="text-center mb-5 mt-3">Login</h1>
            <div class="container">
                <div class="row mb-4">
                    <div class="btn-group" name="user-type" role="group" aria-label="User Type Select">
                        <input type="radio" class="btn-check" name="user-type" id="parent" autocomplete="off" checked>
                        <label class="btn btn-outline-warning" for="parent">Parent</label>

                        <input type="radio" class="btn-check" name="user-type" id="driver" autocomplete="off">
                        <label class="btn btn-outline-warning" for="driver">Driver</label>
                    </div>
                </div>
                <div class="row">
                    <label for="login-email" name="login-email" class="col-sm-2 col-form-label me-2">Email</label>
                </div>
                <div class="row mb-4">
                    <div>
                        <input type="email" name="login-email" class="form-control" id="login-email">
                    </div>
                </div>
                <div class="row mb-4">
                    <label for="login-password" class="col-sm-2 col-form-label me-2">Password</label>
                    <div>
                        <input type="password" name="login-password" class="form-control" id="login-password">
                    </div>
                </div>
                <div class="row justify-content-center mt-5">
                    <div class="col-6 text-center">
                        <button type="submit" id="login-button" class="btn px-5 btn-warning mx-auto">Login</button>
                    </div>
                </div>
                <div class="row mt-4 p-4 border-top">
                    <div class="col text-end align-self-center">
                        Don't have an account?
                    </div>
                    <div class="col">
                        <a href="signup.html" class="btn btn-warning px-5">Sign Up</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>

</html>