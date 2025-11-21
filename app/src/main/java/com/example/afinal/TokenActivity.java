package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TokenActivity extends AppCompatActivity {

    private EditText editTextCode;
    private TextView textViewResult;
    private String generatedCode;
    private int attempts = 0;

    //almacena ek tiempo en que se bloqueo la sesion
    private long blockStartTime = 0;
    //establece el numero maximo de intentos
    private static final int MAX_ATTEMPTS = 3;

    // establece el tiempo de bloqueo
    private static final int BLOCK_TIME_MS = 30 * 1000; // 30 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

        //Se asignan los elementos del xml a las variables correspondientes.

        editTextCode = findViewById(R.id.editTextCode);
        textViewResult = findViewById(R.id.textViewResult);

        Button btnGenerateCode = findViewById(R.id.btnGenerateCode);
        btnGenerateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            //escucha cuando se hace clic al boton
            public void onClick(View v) {
                //Si la sesión está bloqueada, muestra un mensaje de bloqueo
                if (isBlocked()) {
                    showToast("Sesión bloqueada por múltiples intentos");
                } else {
                    //Si no lo está, genera un código aleatorio y lo muestra en un mensaje.
                    generatedCode = generateRandomCode();
                    showToast("Código generado: " + generatedCode);
                }
            }
        });

        Button btnValidateCode = findViewById(R.id.btnValidateCode);
        btnValidateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Si la sesión está bloqueada, muestra un mensaje de bloqueo.
                if (isBlocked()) {
                    showToast("Sesión bloqueada por múltiples intentos");
                } else {
                    // Si no lo está, verifica si el código ingresado coincide con el código generado.
                    String enteredCode = editTextCode.getText().toString();
                    if (enteredCode.equals(generatedCode)) {
                        //Si coinciden, se redirije al main activity 2
                        startMainActivity2();
                    } else {
                        //Si no coinciden, se incrementa el contador de intentos
                        attempts++;
                        //si se excede el límite de intentos, se bloquea la sesión.
                        if (attempts >= MAX_ATTEMPTS) {
                            blockStartTime = SystemClock.elapsedRealtime();
                            showToast("Sesión bloqueada por múltiples intentos");
                        } else {
                            showToast("Código no válido, intento #" + attempts);
                        }
                    }
                }
            }
        });

        // Maneja el desbloqueo después de 30 segundos.
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            //Comprueba si la sesión está bloqueada y si ha transcurrido el tiempo de bloqueo
            public void run() {
                if (isBlocked() && SystemClock.elapsedRealtime() - blockStartTime >= BLOCK_TIME_MS) {
                    // Si ya se cumplio el tiempo, desbloquea la sesión.
                    unblockSession();
                }
                handler.postDelayed(this, 1000); // Comprueba cada segundo.
            }
        }, 1000);
    }

    //generar un número entero aleatorio entre 10000 y 99999
    private String generateRandomCode() {
        Random rand = new Random();
        //Luego, se convierte este número en una cadena
        // lo devuelve como el código generado.
        int code = 10000 + rand.nextInt(90000);
        return String.valueOf(code);
    }

    //muestra un mensaje emergente (toast) en la pantalla
    private void showToast(String message) {
        Toast.makeText(TokenActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    //verifica si la sesión está bloqueada en función del número de intentos y el tiempo transcurrido desde el inicio del bloqueo.
    private boolean isBlocked() {
        return attempts >= MAX_ATTEMPTS && (SystemClock.elapsedRealtime() - blockStartTime) >= BLOCK_TIME_MS;
    }

    // desbloquear la sesión.
    // restable el contador de intentos y el tiempo de inicio de bloqueo.
    private void unblockSession() {
        attempts = 0;
        blockStartTime = 0;
    }

    //inicia el MainActivity2.
    private void startMainActivity2() {
        Intent intent = new Intent(TokenActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
