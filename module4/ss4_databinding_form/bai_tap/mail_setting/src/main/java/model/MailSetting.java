package model;

public class MailSetting {
    private String language;
    private String pageSize;
    private boolean filler = false;
    private String signature;

    public MailSetting() {
    }

    public MailSetting(String    language, String pageSize, boolean filler, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.filler = filler;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFiller() {
        return filler;
    }

    public void setFiller(boolean filler) {
        this.filler = filler;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
