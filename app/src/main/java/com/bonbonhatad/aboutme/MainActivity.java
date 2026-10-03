package com.bonbonhatad.aboutme;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.content.res.ColorStateList;
import android.view.*;
import android.widget.*;
import android.graphics.drawable.GradientDrawable;

public class MainActivity extends Activity {
    LinearLayout content;
    int purple = Color.rgb(108,99,255), dark = Color.rgb(15,16,32), text = Color.rgb(35,35,45), muted = Color.rgb(105,105,120);

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        build();
        showHome();
    }

    TextView tv(String s, float size, int color, boolean bold) {
        TextView t = new TextView(this); t.setText(s); t.setTextSize(size); t.setTextColor(color);
        t.setTypeface(Typeface.DEFAULT, bold ? Typeface.BOLD : Typeface.NORMAL); t.setPadding(0,6,0,6); return t;
    }
    GradientDrawable bg(int color, float r) { GradientDrawable g=new GradientDrawable(); g.setColor(color); g.setCornerRadius(r); return g; }

    void build() {
        LinearLayout root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setBackgroundColor(Color.rgb(248,248,252));
        content=new LinearLayout(this); content.setOrientation(LinearLayout.VERTICAL); content.setPadding(24,18,24,24);
        ScrollView scroll=new ScrollView(this); scroll.addView(content);
        root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));

        LinearLayout nav=new LinearLayout(this); nav.setPadding(10,8,10,8); nav.setGravity(Gravity.CENTER);
        String[] names={"Home","About","Work","Skills"};
        for(String n:names){ Button x=new Button(this); x.setText(n); x.setTextSize(11); x.setAllCaps(false); x.setTextColor(Color.WHITE); x.setBackgroundTintList(ColorStateList.valueOf(dark));
            x.setOnClickListener(v->{ if(n.equals("Home"))showHome(); else if(n.equals("About"))showAbout(); else if(n.equals("Work"))showWork(); else showSkills();});
            nav.addView(x,new LinearLayout.LayoutParams(0,52,1)); }
        root.addView(nav); setContentView(root);
    }

    void base(String title,String subtitle) {
        content.removeAllViews();
        TextView h=tv(title,30,dark,true); content.addView(h);
        content.addView(tv(subtitle,15,muted,false),new LinearLayout.LayoutParams(-1,-2));
        Space sp=new Space(this); content.addView(sp,new LinearLayout.LayoutParams(1,12));
    }
    void card(String title,String body) {
        LinearLayout c=new LinearLayout(this); c.setOrientation(LinearLayout.VERTICAL); c.setPadding(20,16,20,16); c.setBackground(bg(Color.WHITE,28));
        TextView h=tv(title,19,text,true); c.addView(h); c.addView(tv(body,14,muted,false));
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,-2); p.setMargins(0,8,0,8); content.addView(c,p);
    }

    void showHome() {
        base("Hi, I’m Bonbon 👋","A quick interactive introduction.");
        TextView hero=tv("Bonbon Hatad",34,dark,true); content.addView(hero);
        content.addView(tv("Public administration • digital creativity • technology",15,purple,true));
        card("📍 San Miguel, Zamboanga del Sur","Based in the Philippines, working around local government programs, digital content, and technology.");
        card("💡 What I enjoy","Building useful digital tools, designing public information materials, exploring AI, and turning ideas into practical projects.");
        Button b=new Button(this); b.setText("Explore my journey →"); b.setAllCaps(false); b.setTextColor(Color.WHITE); b.setBackground(bg(purple,60)); b.setOnClickListener(v->showAbout()); content.addView(b);
    }
    void showAbout() {
        base("About Me","A snapshot of my background and interests.");
        card("🎓 Education","Master in Public Administration — with coursework and research interests in public administration and research methods.");
        card("🏛️ Public Service","Experience supporting local government operations, events, communications, digital systems, and disaster-risk-reduction activities.");
        card("🚀 Interests","Artificial intelligence, education technology, web/app development, networking, digital design, and space exploration.");
        card("✨ Personal style","Curious, hands-on, and always interested in learning by building.");
    }
    void showWork() {
        base("What I Do","Selected areas of work and projects.");
        card("🎨 Digital & Creative","Graphics, layouts, event materials, social media content, presentations, and public-information visuals.");
        card("💻 IT & Systems","Computer and network troubleshooting, website and GovMail maintenance, QR-based systems, and practical digital tools.");
        card("🌏 Local Government Support","Assisting programs, meetings, trainings, documentation, and digital communication for municipal operations.");
        card("🧩 Projects","Interactive webpages, QR/TTS concepts, data tools, AI-assisted content, and Android/app ideas.");
    }
    void showSkills() {
        base("Skills & Toolbox","Tap a skill to reveal a little more.");
        String[][] data={{"💻 Technology","Web development • Android concepts • networking • troubleshooting"},{"🎨 Design","Graphics • layouts • presentations • social content"},{"🤖 AI","AI-assisted writing • prompts • automation ideas • creative workflows"},{"📊 Research","Public administration • research methods • data analysis concepts"}};
        for(String[] d:data){ Button b=new Button(this); b.setText(d[0]+"   "+d[1]); b.setAllCaps(false); b.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL); b.setPadding(18,0,18,0); b.setTextColor(text); b.setBackground(bg(Color.WHITE,24));
            b.setOnClickListener(v->Toast.makeText(this,d[1],Toast.LENGTH_SHORT).show());
            LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,64); p.setMargins(0,7,0,7); content.addView(b,p); }
        content.addView(tv("This app is a starting profile and can be customized with your photo, links, contact details, projects, and a timeline.",13,muted,false));
    }
}
