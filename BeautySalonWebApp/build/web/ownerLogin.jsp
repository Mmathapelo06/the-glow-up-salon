<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Glow Up Salon | Owner Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="style.css">
    </head>

    <body>

        <div class="login-container">

            <h1>Glow Up Salon</h1>

            <p>Salon Owner Login</p>

            <!-- Display error message only when login fails -->
            <%
                String errorMessage =
                        (String) request.getAttribute("errorMessage");

                if (errorMessage != null) {
            %>

                <p class="error-message">
                    <%= errorMessage%>
                </p>

            <%
                }
            %>

            <form action="OwnerLoginServlet.do" method="post">

                <label for="userName">Username</label>

                <input type="text"
                       id="userName"
                       name="userName"
                       placeholder="Enter your username"
                       required>

                <label for="password">Password</label>

                <input type="password"
                       id="password"
                       name="password"
                       placeholder="Enter your password"
                       required>

                <button type="submit" class="login-btn">
                    Login
                </button>

            </form>

            <a href="index.html" class="back-link">
                 Back to Home
            </a>

        </div>

    </body>
</html>