package com.notebook.collegeapp.ebook;

public class EbookData {
    private String pdfUrl,pdfTitle;

    public EbookData() {
    }

    public EbookData(String pdfUrl, String pdfTitle) {
        this.pdfUrl = pdfUrl;
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }
}