package com.stripe.params;

import com.google.auto.value.AutoValue;

import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nullable;

@AutoValue
public abstract class UpdateProduct {
	@Nullable abstract Boolean active();

	@Nullable abstract String attributes();

	@Nullable abstract String caption();

	@Nullable abstract String deactivateOn();

	@Nullable abstract String description();

	@Nullable abstract String images();

	@Nullable abstract Map<String, String> metadata();

	@Nullable abstract String name();

	@Nullable abstract Boolean shippable();

	@Nullable abstract String url();

	public static Builder builder() {
		return new AutoValue_UpdateProduct.Builder();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> m = new HashMap<String, Object>();
		if (active() != null) {
			m.put("active", active());
		}
		if (attributes() != null) {
			m.put("attributes", attributes());
		}
		if (caption() != null) {
			m.put("caption", caption());
		}
		if (deactivateOn() != null) {
			m.put("deactivate_on", deactivateOn());
		}
		if (description() != null) {
			m.put("description", description());
		}
		if (images() != null) {
			m.put("images", images());
		}
		if (metadata() != null) {
			m.put("metadata", metadata());
		}
		if (name() != null) {
			m.put("name", name());
		}
		if (shippable() != null) {
			m.put("shippable", shippable());
		}
		if (url() != null) {
			m.put("url", url());
		}
		return m;
	}

	@AutoValue.Builder
	public abstract static class Builder {
		public abstract Builder active(Boolean value);

		public abstract Builder attributes(String value);

		public abstract Builder caption(String value);

		public abstract Builder deactivateOn(String value);

		public abstract Builder description(String value);

		public abstract Builder images(String value);

		public abstract Builder metadata(Map<String, String> value);

		public abstract Builder name(String value);

		public abstract Builder shippable(Boolean value);

		public abstract Builder url(String value);

		public abstract UpdateProduct build();
	}
}
