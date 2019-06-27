package com.lsq.merchant.bean;

import com.lsq.merchant.domain.Company;
import com.lsq.merchant.domain.Merchant;
import com.lsq.message.domain.MyMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantLoginReturn {
    private String account;

    private String identity;

    private String description;

    private Merchant userData;

    private Company companyData;
}
