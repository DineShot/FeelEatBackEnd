package dine.dineshotbackend.badge.entity;

import dine.dineshotbackend.user.entity.User;

import java.io.Serializable;

public class UserBadgeId implements Serializable {
    private Badge badgeCode;
    private User userCode;
}
