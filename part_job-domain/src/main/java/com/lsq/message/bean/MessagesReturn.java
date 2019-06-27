package com.lsq.message.bean;

import com.lsq.message.domain.MyMessages;
import lombok.Data;

import java.util.List;

@Data
public class MessagesReturn {
    private String sendAccount;

    List<MyMessages> messagesList;
}
