package mx.gnc.as.gutsncode.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Required;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.SwaggerDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveObject {
	
//	private Optional<String> postId;
//	private Optional<String> textId;
//	private Optional<Integer> page;
//	private Optional<Integer> sizePage;
//	private Optional<String> topic;
//	private Optional<String> type;
//	private Optional<String> name;
	
	private Integer page;
	private Integer sizePage;
	private String topic;
	private String type;
	
}
