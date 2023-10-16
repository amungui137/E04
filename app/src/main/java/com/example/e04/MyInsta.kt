package com.example.e04

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true,
    apiLevel = 34,
    device = Devices.NEXUS_5,
)

@Composable
fun MyInstaLogin() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val instagramColor = Color(0xFF0197FD);


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.Top
        )
        {
            Image(
                painter = painterResource(id = R.drawable.insta),
                contentDescription = "logoInstagram",
                modifier = Modifier
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                value = email,
                onValueChange = { email = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray, // Cambia el color del borde cuando el campo de texto está enfocado
                    unfocusedBorderColor = Color.LightGray // Cambia el color del borde cuando el campo de texto no está enfocado
                ),
                placeholder = { Text(text = "Email adress", color = Color.Gray) },
                singleLine = true,

                )
        }

        Row {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.LightGray
                ),
                placeholder = { Text(text = "Password", color = Color.Gray) },
                singleLine = true,
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisibility)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (passwordVisibility) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(imageVector = image, description)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }

        Text(
            text = "Forgotten password?",
            color = instagramColor,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .height(35.dp)
                .background(instagramColor),
            onClick = { /* Acción de inicio de sesión */ },
            shape = RoundedCornerShape(5.dp),
            enabled = email.isValidEmail() && password.length >= 7,
        ) {
            Text(
                text = "Log In",
                color = Color.White,
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
            Text(
                text = "OR",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "logoFacebook",
                modifier = Modifier
                    .fillMaxWidth(0.05f)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Log in with Facebook",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = instagramColor
            )
        }
    }


    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
        )
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.padding(bottom = 20.dp)
    ) {
        Text(
            text = "Don't have an account?",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.LightGray
        )
        Text(
            text = " Sign Up",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = instagramColor
        )
    }
}

fun String.isValidEmail(): Boolean {
    // Lógica para validar el formato del correo electrónico
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}


