<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
<link>
    
</head>

<body>





    <div class="layout-login__overlay"></div>
    <div class="layout-login__form bg-white" data-perfect-scrollbar>
        <div class="d-flex justify-content-center mt-2 mb-5 navbar-light">
            <a href="index.html" class="navbar-brand" style="min-width: 0">
                <img class="navbar-brand-icon" src="assets/images/logo.png" width="250" alt="Stack">
            </a>
        </div>

        <h4 class="m-0">Welcome back!</h4>
        <p class="mb-5">Login to access your account </p>
		<div class="alert alert-danger" role="alert">
  				${mess}
		</div>
        <form action="login" method="post">
            <div class="form-group">
                <label class="text-label" for="email_2">Email :</label>
                <div class="input-group input-group-merge">
                    <input id="email_2" name="email" value="${email1}" type="email"  class="form-control form-control-prepended" placeholder="john@doe.com">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="far fa-envelope"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="text-label" for="password_2">Password:</label>
                <div class="input-group input-group-merge">
                    <input id="password_2" name="password" type="password" required="" class="form-control form-control-prepended" value="${pass1}" placeholder="Enter your password">
                    <div class="input-group-prepend">
                        <div class="input-group-text">
                            <span class="fa fa-key"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group mb-5">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" checked="" name="remember" value="1">
                    <label class="custom-control-label"  for="remember">Remember me</label>
                </div>
            </div>
            <div class="form-group text-center">
                <button class="btn btn-primary mb-5" type="submit">Login</button><br>
                <a href="">Forgot password?</a> <br> Don't have an account? <a class="text-body text-underline" href="signup">Sign up!</a>
            </div>
        </form>
    </div>


  





</body>

</html>