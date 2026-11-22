package dev.carbon.pocketlauncher.ui.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dev.carbon.pocketlauncher.R;

public class AboutActivity extends BaseActivity {

    private static final String URL_PORTFOLIO = "https://carbon.is-a.dev/";
    private static final String URL_GITHUB = "https://github.com/carbonthecoder";
    private static final String URL_DISCORD = "https://discord.com/users/954250474763198494";
    private static final String DISCORD_ID = "954250474763198494";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setActiveNavTab(R.id.nav_tab_about);
        setupLinks();
    }

    private void setupLinks() {
        setupLinkButton(R.id.btn_portfolio, URL_PORTFOLIO);
        setupLinkButton(R.id.btn_github, URL_GITHUB);
        setupLinkButton(R.id.btn_discord, URL_DISCORD);

        View copyBtn = findViewById(R.id.btn_copy_discord);
        if (copyBtn != null) {
            copyBtn.setOnClickListener(v -> {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Discord ID", DISCORD_ID);
                if (clipboard != null) {
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(this, "Copied Discord ID: " + DISCORD_ID, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void setupLinkButton(int viewId, String url) {
        View btn = findViewById(viewId);
        if (btn == null) return;
        btn.setOnClickListener(v -> {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            } catch (android.content.ActivityNotFoundException ignored) {}
        });
    }
}
