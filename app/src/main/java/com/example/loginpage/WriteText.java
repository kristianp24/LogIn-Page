package com.example.loginpage;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WriteText {
    private String email;
    private String name;
    private String lastName;
    private String password;

    public WriteText(String name, String email, String lastName, String password) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
    }

    public int writeInFile(File file){

        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);){

            writer.write(email);
            writer.newLine();
            writer.write(name);
            writer.newLine();
            writer.write(lastName);
            writer.newLine();
            writer.write(password);
            writer.newLine();
            writer.close();
            return 0;
        }
        catch(Exception e){
            Log.e(TAG, e.getMessage(), e);
          return -1;
        }

    }
}
