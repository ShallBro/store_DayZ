package com.example.store_dayz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;

public class CustomAnnotator extends AbstractAnnotator {
  @Override
  public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
    super.propertyField(field, clazz, propertyName, propertyNode);

    if (propertyName.equals("availableServers")) {
      field.name("available_servers");
      try {
        field.annotate(JsonProperty.class).param("available_servers", Class.forName(propertyNode.get("available_servers").asText()));
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
