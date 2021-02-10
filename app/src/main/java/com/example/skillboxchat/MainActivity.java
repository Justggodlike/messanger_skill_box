package com.example.skillboxchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText chatMessage = findViewById(R.id.chatMessage);
        ImageView sendButton = findViewById(R.id.sendButton);
        RecyclerView chatWindow = findViewById(R.id.chatWindow);

        final MessageController controller = new MessageController();
        controller.setIncomingLayout(R.layout.message)
                    .setOutgoingLayout(R.layout.omessage)
                    .setMessageTextId(R.id.messageText)
                    .setUserNameId(R.id.userName)
                    .setMessageTimeId(R.id.messageTime)
                    .appendTo(chatWindow, this);

        controller.addMessage(new MessageController.Message("Hello everyone", "user1", true));
        controller.addMessage(new MessageController.Message("Hey bro", "user2", false));

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.addMessage(new MessageController.Message(chatMessage.getText().toString(), "user2", true));
                chatMessage.setText("");
            }
        });



    }
}
