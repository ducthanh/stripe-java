package com.stripe.model.issuing;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.BalanceTransaction;
import com.stripe.model.ExpandableField;
import com.stripe.model.HasId;
import com.stripe.model.MetadataStore;
import com.stripe.model.StripeObject;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Authorization extends APIResource implements MetadataStore<Authorization>, HasId {
  @Getter(onMethod = @__({@Override})) String id;
  String object;
  Boolean approved;
  String authorizationMethod;
  String authorizedAmount;
  String authorizedCurrency;
  List<BalanceTransaction> balanceTransactions;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    ExpandableField<Card> card;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    ExpandableField<Cardholder> cardholder;
  Long created;
  Long heldAmount;
  String heldCurrency;
  Boolean isHeldAmountControllable;
  Boolean livemode;
  MerchantData merchantData;
  @Getter(onMethod = @__({@Override})) Map<String, String> metadata;
  Long pendingAuthorizedAmount;
  Long pendingHeldAmount;
  List<RequestHistory> requestHistory;
  String status;
  List<Transaction> transactions;
  VerificationData verificationData;

  // <editor-fold desc="card">
  public String getCard() {
    return (this.card != null) ? this.card.getId() : null;
  }

  public void setCard(String cardId) {
    this.card = setExpandableFieldID(cardId, this.card);
  }

  public Card getCardObject() {
    return (this.card != null) ? this.card.getExpanded() : null;
  }

  public void setCardObject(Card c) {
    this.card = new ExpandableField<Card>(c.getId(), c);
  }
  // </editor-fold>

  // <editor-fold desc="cardholder">
  public String getCardholder() {
    return (this.cardholder != null) ? this.cardholder.getId() : null;
  }

  public void setCardholder(String cardholderId) {
    this.cardholder = setExpandableFieldID(cardholderId, this.cardholder);
  }

  public Cardholder getCardholderObject() {
    return (this.cardholder != null) ? this.cardholder.getExpanded() : null;
  }

  public void setCardholderObject(Cardholder c) {
    this.cardholder = new ExpandableField<Cardholder>(c.getId(), c);
  }
  // </editor-fold>

  // <editor-fold desc="approve">
  /**
   * Approve an issuing authorization.
   */
  public Authorization approve(Map<String, Object> params) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return approve(params, null);
  }

  /**
   * Approve an issuing authorization.
   */
  public Authorization approve(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.POST, String.format("%s/approve",
        instanceURL(Authorization.class, this.getId())), params, Authorization.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="decline">
  /**
   * Decline an issuing authorization.
   */
  public Authorization decline(Map<String, Object> params) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return decline(params, null);
  }

  /**
   * Decline an issuing authorization.
   */
  public Authorization decline(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.POST, String.format("%s/decline",
        instanceURL(Authorization.class, this.getId())), params, Authorization.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="list">
  /**
   * List all issuing authorizations.
   */
  public static AuthorizationCollection list(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return list(params, null);
  }

  /**
   * List all issuing authorizations.
   */
  public static AuthorizationCollection list(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException, APIConnectionException,
      CardException, APIException {
    return requestCollection(classURL(Authorization.class), params,
      AuthorizationCollection.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="retrieve">
  /**
   * Retrieve an issuing authorization.
   */
  public static Authorization retrieve(String id) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return retrieve(id, null);
  }

  /**
   * Retrieve an issuing authorization.
   */
  public static Authorization retrieve(String id, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.GET, instanceURL(Authorization.class, id), null,
      Authorization.class, options);
  }

  /**
   * Retrieve an issuing authorization.
   */
  public static Authorization retrieve(String id, Map<String, Object> params,
      RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.GET, instanceURL(Authorization.class, id), params,
      Authorization.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="update">
  /**
   * Update an issuing authorization.
   */
  @Override
  public Authorization update(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return update(params, null);
  }

  /**
   * Update an issuing authorization.
   */
  @Override
  public Authorization update(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.POST, instanceURL(Authorization.class, this.id), params,
      Authorization.class, options);
  }
  // </editor-fold>

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public final class RequestHistory extends StripeObject {
    Boolean approved;
    Long authorizedAmount;
    String authorizedCurrency;
    Long created;
    Long heldAmount;
    String heldCurrency;
    String reason;
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public final class VerificationData extends StripeObject {
    String addressLine1Check;
    String addressZipCheck;
    String cvcCheck;
  }
}
