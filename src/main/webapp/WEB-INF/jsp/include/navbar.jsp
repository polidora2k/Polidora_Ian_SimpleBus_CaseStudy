<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top" style="font-family: FredokaOne;">
    <div class="container-fluid">
      <a href="/" class="navbar-brand">
        <img src="/images/bus.jpg" alt="logo" width="100" />
        <span>SimpleBus</span>
      </a>
      <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <sec:authorize access="isAuthenticated()">
          <div class="navbar-nav">
            <sec:authorize access="hasAuthority('PARENT')">
              <a href="/parent" class="nav-item nav-link">Dashboard</a>
            </sec:authorize>
            <sec:authorize access="hasAuthority('DRIVER')">
              <a href="/driver" class="nav-item nav-link">Dashboard</a>
            </sec:authorize>
            <sec:authorize access="hasAuthority('ADMIN')">
              <a href="/admin" class="nav-item nav-link">Dashboard</a>
            </sec:authorize>
          </div>
        </sec:authorize>
        <div class="navbar-nav ms-auto">
          <sec:authorize access="isAuthenticated()">
            <a href="/user/logout" class="nav-item nav-link">Logout</a>
          </sec:authorize>

          <sec:authorize access="!isAuthenticated()">
            <a href="/user/login" class="nav-item nav-link">Login/Sign Up</a>
          </sec:authorize>

        </div>
      </div>
    </div>
  </nav>