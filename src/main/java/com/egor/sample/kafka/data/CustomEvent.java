package com.egor.sample.kafka.data;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomEvent {
    @SerializedName(value = "event_id")
    private Long eventId;
    @SerializedName(value = "user_id")
    private Long userId;
    @SerializedName(value = "project_id")
    private Long projectId;
    @SerializedName(value = "organization_id")
    private Long organizationId;
    private String time;
    @SerializedName(value = "event_type")
    private String eventType;

}
