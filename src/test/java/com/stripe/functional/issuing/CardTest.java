package com.stripe.functional.issuing;

import static org.junit.Assert.assertNotNull;

import com.stripe.BaseStripeTest;
import com.stripe.exception.StripeException;
import com.stripe.model.issuing.Card;
import com.stripe.model.issuing.CardCollection;
import com.stripe.model.issuing.CardDetails;
import com.stripe.net.APIResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class CardTest extends BaseStripeTest {
  public static final String CARD_ID = "ic_123";

  @Test
  public void testCreate() throws IOException, StripeException {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("currency", "usd");
    params.put("type", "physical");

    final Card card = Card.create(params);

    assertNotNull(card);
    verifyRequest(
        APIResource.RequestMethod.POST,
        String.format("/v1/issuing/cards"),
        params
    );
  }

  @Test
  public void testDetails() throws IOException, StripeException {
    final Card card = Card.retrieve(CARD_ID);

    final CardDetails cardDetails = card.details(null);

    assertNotNull(cardDetails);
    verifyRequest(
        APIResource.RequestMethod.GET,
        String.format("/v1/issuing/cards/%s/details", card.getId()),
        null
    );
  }

  @Test
  public void testRetrieve() throws IOException, StripeException {
    final Card card = Card.retrieve(CARD_ID);

    assertNotNull(card);
    verifyRequest(
        APIResource.RequestMethod.GET,
        String.format("/v1/issuing/cards/%s", CARD_ID)
    );
  }

  @Test
  public void testUpdate() throws IOException, StripeException {
    final Card card = Card.retrieve(CARD_ID);

    final Map<String, String> metadata = new HashMap<String, String>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("metadata", metadata);

    final Card updatedCard = card.update(params);

    assertNotNull(updatedCard);
    verifyRequest(
        APIResource.RequestMethod.POST,
        String.format("/v1/issuing/cards/%s", card.getId()),
        params
    );
  }

  @Test
  public void testList() throws IOException, StripeException {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("limit", 1);

    CardCollection resources = Card.list(params);

    assertNotNull(resources);
    verifyRequest(
        APIResource.RequestMethod.GET,
        String.format("/v1/issuing/cards"),
        params
    );
  }
}
