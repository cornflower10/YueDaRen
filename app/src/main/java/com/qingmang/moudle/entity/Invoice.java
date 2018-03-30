package com.qingmang.moudle.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xiejingbao on 2018/3/30.
 */

public class Invoice implements Parcelable{

    private String companyName;
    private String invoiceNo;
    private int invoiceType;
    private int header;
    private boolean isInvoice;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public boolean isInvoice() {
        return isInvoice;
    }

    public void setInvoice(boolean invoice) {
        isInvoice = invoice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.companyName);
        dest.writeString(this.invoiceNo);
        dest.writeInt(this.invoiceType);
        dest.writeInt(this.header);
        dest.writeByte(this.isInvoice ? (byte) 1 : (byte) 0);
    }

    public Invoice() {
    }

    protected Invoice(Parcel in) {
        this.companyName = in.readString();
        this.invoiceNo = in.readString();
        this.invoiceType = in.readInt();
        this.header = in.readInt();
        this.isInvoice = in.readByte() != 0;
    }

    public static final Creator<Invoice> CREATOR = new Creator<Invoice>() {
        @Override
        public Invoice createFromParcel(Parcel source) {
            return new Invoice(source);
        }

        @Override
        public Invoice[] newArray(int size) {
            return new Invoice[size];
        }
    };
}
