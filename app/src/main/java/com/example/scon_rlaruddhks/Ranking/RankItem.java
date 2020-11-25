package com.example.scon_rlaruddhks.Ranking;

import android.graphics.drawable.Drawable;

public class RankItem {
    String rankNum, teamName;
    Drawable teamIconDrawable;

    public RankItem(String rankNum, String teamName, Drawable teamIconDrawable) {
        this.rankNum = rankNum;
        this.teamName = teamName;
        this.teamIconDrawable = teamIconDrawable;
    }

    public String getRankNum() {
        return rankNum;
    }

    public void setRankNum(String rankNum) {
        this.rankNum = rankNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Drawable getTeamIconDrawable() {
        return teamIconDrawable;
    }

    public void setTeamIconDrawable(Drawable teamIconDrawable) {
        this.teamIconDrawable = teamIconDrawable;
    }
}
