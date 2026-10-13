<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Glow Up Salon | Register Owner</title>

    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="login-container">

        <h1>Glow Up Salon</h1>

        <p>Create Salon Owner Account</p>

        <form action="OwnerRegistrationServlet" method="post">

            <label for="userName">Username</label>

            <input type="text"
                   id="userName"
                   name="userName"
                   required>

            <label for="password">Password</label>

            <input type="password"
                   id="password"
                   name="password"
                   required>

            <button type="submit" class="login-btn">
                Create Account
            </button>

        </form>

        <a href="ownerLogin.jsp" class="back-link">
             Already have an account? Login
        </a>

    </div>

</body>
</html>