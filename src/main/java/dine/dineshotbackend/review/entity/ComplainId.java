package dine.dineshotbackend.review.entity;

import dine.dineshotbackend.user.entity.User;

import java.io.Serializable;

public class ComplainId implements Serializable {
    private Review reviewCode;
    private User userCode;
}
