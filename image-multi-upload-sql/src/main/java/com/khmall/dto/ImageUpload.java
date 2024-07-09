package com.khmall.dto;

import lombok.AllArgsConstructor;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageUpload {
    private int id;
    private String file_name;
    private String upload_dir;
    private String upload_time;
}
