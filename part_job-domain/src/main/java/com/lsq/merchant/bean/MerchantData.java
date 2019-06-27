package com.lsq.merchant.bean;

import com.lsq.merchant.domain.Company;
import com.lsq.merchant.domain.Merchant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantData {
    private Merchant merchant;

    private Company company;
}
