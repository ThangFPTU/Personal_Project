<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="css/login.css"/>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6 mx-auto p-0">
                <div class="card">
                    <div class="login-box">
                        <div class="login-snip"> <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                            <div class="login-space">
                                <form action="login" method="post" >
                                    <div class="login">
                                        <p  style="color: #FFF;"> ${mess} </p>
                                        <div class="group"> <label for="user" class="label">Username</label> <input name="user" type="text" class="input" placeholder="Enter your username"> </div>
                                        <div class="group"> <label for="pass" class="label">Password</label> <input name="pass" type="password" class="input" data-type="password" placeholder="Enter your password"> </div>
                                        
                                        <div class="group"> <input id="check" type="checkbox" class="check" checked> <label for="check"><span class="icon"></span> Keep me Signed in</label> </div>
                                        <div class="group"> <input type="submit" class="button" value="Sign In"> </div>
                                        <div class="hr"></div>
                                        <div class="foot"> <a href="#">Forgot Password?</a> </div>
                                    </div>
                                </form>
                                <form action="sign" method="post">
                                    <div class="sign-up-form">
                                        <div class="group"> <label for="user" class="label">Username</label> <input name="user" type="text" class="input" placeholder="Create your Username"> </div>
                                        <div class="group"> <label for="pass" class="label">Password</label> <input name="pass" type="password" class="input" data-type="password" placeholder="Create your password"> </div>
                                        <div class="group"> <label for="pass" class="label">Repeat Password</label> <input name="repass" type="password" class="input" data-type="password" placeholder="Repeat your password"> </div>
                                        <div class="group"> <label for="pass" class="label">Email Address</label> <input name="email" type="text" class="input" placeholder="Enter your email address"> </div>
                                        <div class="group"> <input type="submit" class="button" value="Sign Up"> </div>
                                        <div class="hr"></div>
                                        <div class="foot"> <label for="tab-1">Already Member?</label> </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
