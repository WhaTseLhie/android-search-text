package pardillo.john.jv.searchanddisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private EditText txtName;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> sourceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtName = this.findViewById(R.id.editText);
        this.lv = this.findViewById(R.id.listView);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        this.lv.setAdapter(adapter);

        sourceList.add("abaddon");
        sourceList.add("alchemist");
        sourceList.add("bloodseeker");
        sourceList.add("chen");
        sourceList.add("juggernaut");
        sourceList.add("pudge");
        sourceList.add("sniper");
        sourceList.add("sven");
        sourceList.add("weaver");
        sourceList.add("zues");

        this.txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                list.clear();
                String name = s.toString();
                Pattern pattern = Pattern.compile(name);

                for(int i=0; i<sourceList.size(); i++) {
                    Matcher m = pattern.matcher(sourceList.get(i));

                    if(m.find()) {
                        list.add(sourceList.get(i));
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }
}
