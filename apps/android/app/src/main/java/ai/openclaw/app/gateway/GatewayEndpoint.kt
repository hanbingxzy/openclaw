package ai.openclaw.app.gateway

data class GatewayEndpoint(
  val stableId: String,
  val name: String,
  val host: String,
  val port: Int,
  val path: String = "",
  val lanHost: String? = null,
  val tailnetDns: String? = null,
  val gatewayPort: Int? = null,
  val canvasPort: Int? = null,
  val tlsEnabled: Boolean = false,
  val tlsFingerprintSha256: String? = null,
) {
  companion object {
    fun manual(host: String, port: Int, path: String = ""): GatewayEndpoint =
      GatewayEndpoint(
        stableId = "manual|${host.lowercase()}|$port|$path",
        name = if (path.isNotEmpty()) "$host:$port$path" else "$host:$port",
        host = host,
        port = port,
        path = path,
        tlsEnabled = false,
        tlsFingerprintSha256 = null,
      )
  }
}
