package com.example.demo.Lesson16;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
// @PropertySource("classpath:loda.yml") // Đánh dấu để lấy config từ trong file loda.yml
// Nếu không có annotation này, Spring sẽ sử dụng file mặc định (classpath:application.yml trong thư mục resources)
// @ConfigurationProperties, annotation này đánh dấu class bên dưới là properties, các thuộc tính sẽ được tự động nạp vào khi Spring khởi tạo.
@ConfigurationProperties(prefix = "loda") // Chỉ lấy các config có tiền tố là "loda"

public class AppProperties {
    private String email;
    private String googleAnalyticsId;

    private List<String> authors;

    private Map<String, String> exampleMap;

}
