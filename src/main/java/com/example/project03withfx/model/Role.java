package com.example.project03withfx.model;


public enum Role {
    ADMIN {
        public String toString() {
            return "Admin";
        }
    },

    MEMBER {
        public String toString() {
            return "Team Member";
        }
    },

    LEADER {
        public String toString() {
            return "Team Leader";
        }
    }

}
