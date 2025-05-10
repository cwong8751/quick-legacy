package top.wqis.quick;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import jp.wasabeef.richeditor.RichEditor;

public class EditorActivity extends AppCompatActivity {



    RichEditor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Toolbar toolbar = findViewById(R.id.editor_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Init editor
        editor = findViewById(R.id.editor);
        editor.setEditorHeight(200);
        editor.setFontSize(20);
        editor.setPadding(20,20,20,20);
        editor.setPlaceholder("Compose here...");

        initEditBar();
    }


    public void initEditBar(){
        ImageButton undoBtn = findViewById(R.id.undo_button);
        ImageButton redoBtn = findViewById(R.id.redo_button);
        ImageButton checkBoxBtn = findViewById(R.id.checkbox_button);
        ImageButton linkBtn = findViewById(R.id.link_button);

        undoBtn.setOnClickListener(view -> editor.undo());

        redoBtn.setOnClickListener(view -> editor.redo());

        checkBoxBtn.setOnClickListener(view -> editor.insertTodo());

        linkBtn.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add link");

            final View custLayout = getLayoutInflater().inflate(R.layout.add_link_dialog,null);
            builder.setView(custLayout);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Add link

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.editor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.delete_menu_item:
               // Delete note

            case R.id.save_menu_item:
                // Save note

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}