package co.krypt.krypton.pgp.publickey;

import java.io.DataOutputStream;
import java.io.IOException;

import co.krypt.krypton.pgp.packet.Serializable;
import co.krypt.krypton.pgp.packet.SignedSignatureAttributes;

/**
 * Created by Kevin King on 6/13/17.
 * Copyright 2017. KryptCo, Inc.
 */

public class SignedPublicKeySelfCertification extends Serializable {
    public final UnsignedPublicKeySelfCertification certification;
    public final SignedSignatureAttributes signature;

    public SignedPublicKeySelfCertification(UnsignedPublicKeySelfCertification certification, SignedSignatureAttributes signature) {
        this.certification = certification;
        this.signature = signature;
    }

    @Override
    public void serialize(DataOutputStream out) throws IOException {
        certification.publicKeyPacket.serialize(out);
        certification.userIDPacket.serialize(out);
        signature.serialize(out);
    }
}
